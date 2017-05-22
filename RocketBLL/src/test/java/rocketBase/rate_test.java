package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.RateException;

public class rate_test {

	
	@Test
	public void TestExcept() throws RateException{
		assert rocketBase.RateBLL.getRate(420) == 23424;
	}
	ExpectedException e = ExpectedException.none();
	@Test
	public void Test() throws RateException{
		e.expect(RateException.class);
		rocketBase.RateBLL.getRate(12);
	}

}
