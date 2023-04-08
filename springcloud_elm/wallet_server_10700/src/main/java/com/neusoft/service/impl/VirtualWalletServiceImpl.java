package com.neusoft.service.impl;

import com.neusoft.po.VirtualWallet;
import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.mapper.OrdersMapper;
import com.neusoft.mapper.VirtualWalletMapper;
import com.neusoft.mapper.VirtualWalletTransactionMapper;
import com.neusoft.po.Orders;
import com.neusoft.service.CreditsWalletService;
import com.neusoft.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {
	@Autowired
	private VirtualWalletMapper virtualWalletMapper;
	@Autowired
	private VirtualWalletTransactionMapper virtualWalletTransactionMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private CreditsWalletService creditsWalletService;

	@Override
	public VirtualWallet getVirtualWalletById(String userId) {
		return virtualWalletMapper.getVirtualWalletById(userId);
	}

	// 扣款
	@Override
	public int deduct(Double amount, String userId) throws Exception {
		VirtualWallet wallet = getVirtualWalletById(userId);
			wallet.deduct(amount);
			double one = wallet.getBalance();
			BigDecimal two = new BigDecimal(one);
			double three = two.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			return virtualWalletMapper.updateBalance(three, userId);
	}

	// 提现
	@Override
	public int withdraw(Double amount, String userId, String walletInId) throws Exception {
		try {
			deduct(amount, userId);
		} catch (Exception e) {
			System.out.println("余额不足");
			return 0;
		}
		// 创建流水
		VirtualWalletTransaction transaction = new VirtualWalletTransaction(amount, 2, userId, walletInId);
		return virtualWalletTransactionMapper.saveVirtualWalletTransaction(transaction);
	}

	// 充值
	@Override
	public int topUp(Double amount, String userId, String walletOutId) throws Exception {
		VirtualWallet wallet = getVirtualWalletById(userId);
		wallet.topUp(amount);
		virtualWalletMapper.updateBalance(wallet.getBalance(), userId);
		// 创建流水
		VirtualWalletTransaction transaction = new VirtualWalletTransaction(amount, 3, walletOutId, userId);
		return virtualWalletTransactionMapper.saveVirtualWalletTransaction(transaction);
	}
	//查询余额
	@Override
	public Double getVirtualWalletBalance(String userId) {
		return virtualWalletMapper.getVirtualWalletbalance(userId);
	}
	//查询流水
	@Override
	public List<VirtualWalletTransaction> listTransByUserId(String userId) {
		return virtualWalletTransactionMapper.listTransByUserId(userId);
	}

	// 钱包支付
	@Override
	public int payByWallet(Integer orderId, String userId) throws Exception {
		Orders order = ordersMapper.getOrdersById(orderId);
		try {
			if (order.getOrderState() == 0) {
				// 支付
				try {
					deduct(order.getOrderTotal(), userId);
				} catch (Exception e) {
					System.out.println("余额不足");
					return 0;
				}
				// 添加积分
				creditsWalletService.creditsAdd(order.getOrderTotal().intValue(), userId);
				// 创建流水
				VirtualWalletTransaction transaction = new VirtualWalletTransaction(order.getOrderTotal(), 1, userId,
						order.getBusinessId().toString());
				virtualWalletTransactionMapper.saveVirtualWalletTransaction(transaction);
				return ordersMapper.getOrderPayed(orderId);
			} else {
				throw new Exception("已支付");
			}
		} catch (Exception e) {
			return 0;
		}
	}
}
