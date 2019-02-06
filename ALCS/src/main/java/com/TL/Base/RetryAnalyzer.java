package com.TL.Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class RetryAnalyzer implements IRetryAnalyzer {
 
 private static int counter = 0;
 int retryLimit = 1;
 /*
 * (non-Javadoc)
 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
 * 
 * This method decides how many times a test needs to be rerun.
 * TestNg will call this method every time a test fails. So we 
 * can put some code in here to decide when to rerun the test.
 * 
 * Note: This method will return true if a tests needs to be retried
 * and false it not.
 *
 */
 
 @Override
 public boolean retry(ITestResult result) {
 
 if(getCounter() < retryLimit)
 {
 setCounter(getCounter() + 1);
 return true;
 }
 return false;
 }


public static void setCounter(int counter) {
	RetryAnalyzer.counter = counter;
}

public static int getCounter() {
	// TODO Auto-generated method stub
	return counter;
}
}