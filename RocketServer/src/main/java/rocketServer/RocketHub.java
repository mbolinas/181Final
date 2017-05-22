package rocketServer;

import java.io.IOException;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//RateBLL.getPayment(rate, periods, start, end, false)
			
			double start = lq.getdAmount() - lq.getiDownPayment();
			double dRate = RateBLL.getPayment(lq.getdRate() / 1200, lq.getiTerm() / 12, start, 0, false);
			lq.setdRate(dRate);
			
			sendToAll(lq);
		}
	}
}
