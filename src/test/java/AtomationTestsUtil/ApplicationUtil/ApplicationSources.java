package AtomationTestsUtil.ApplicationUtil;

public class ApplicationSources {
        private String baseUrl;
        private long implicitTimeOut;
        private String browserName;

        public ApplicationSources() {
            this.baseUrl = new String();
            this.implicitTimeOut = 30;
            this.browserName = new String();
        }

        public static ApplicationSources get() {
            return new ApplicationSources();
        }

        public ApplicationSources setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public ApplicationSources setImplicitTimeOut(long implicitTimeOut) {
            this.implicitTimeOut = implicitTimeOut;
            return this;
        }

        public ApplicationSources setBrowserName(String browserName) {
            this.browserName = browserName;
            return this;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public long getImplicitTimeOut() {
            return implicitTimeOut;
        }

        public String getBrowserName() {
            return browserName;
        }
    }

