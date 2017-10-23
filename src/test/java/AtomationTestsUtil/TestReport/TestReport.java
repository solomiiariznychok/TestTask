package AtomationTestsUtil.TestReport;

import org.testng.*;

    public class TestReport implements ITestListener {

        @Override
        public void onStart(ITestContext context) {
            Log4jWrapper.get().info(" Tests suite running ");
        }

        @Override
        public void onTestStart(ITestResult result) {
            Log4jWrapper.get().info(" Tests are running ");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            Log4jWrapper.get().info(" TEST " + result.getName() + " PASSED");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            Log4jWrapper.get().info(" TEST " + result.getName() + " FAILED");
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            Log4jWrapper.get().info(" TEST " + result.getName() + " SKIPPED");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("TOTAL Passed TESTS: " + context.getPassedTests());
            System.out.println("TOTAL Failed TESTS: " + context.getFailedTests());
        }

    }