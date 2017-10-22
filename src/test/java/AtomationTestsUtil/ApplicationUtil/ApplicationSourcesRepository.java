package AtomationTestsUtil.ApplicationUtil;

public class ApplicationSourcesRepository {
        private static volatile ApplicationSourcesRepository instance = null;

        private ApplicationSourcesRepository() {
        }

        public static ApplicationSourcesRepository get() {
            return new ApplicationSourcesRepository();
        }

        public ApplicationSources getURLByFirefox() {
            return ApplicationSources.get().setBaseUrl("www.ia.ca").setImplicitTimeOut(10).setBrowserName("firefox");
        }

        public ApplicationSources getURLByChrome() {
            return ApplicationSources.get().setBaseUrl("http://ia.ca").setImplicitTimeOut(10).setBrowserName("chrome");
        }
    }