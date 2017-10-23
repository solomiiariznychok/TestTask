package AtomationTestsUtil.ApplicationUtil;

public class ApplicationSourcesRepository {
        private static volatile ApplicationSourcesRepository instance = null;

        private ApplicationSourcesRepository() {
        }

        public static ApplicationSourcesRepository get() {
            return new ApplicationSourcesRepository();
        }

        public ApplicationSources getURLByFireFox() {
            return ApplicationSources.get().setBaseUrl("http://ia.ca").setImplicitTimeOut(30).setBrowserName("firefox");
        }

        public ApplicationSources getURLByChrome() {
            return ApplicationSources.get().setBaseUrl("http://ia.ca").setImplicitTimeOut(30).setBrowserName("chrome");
        }
    }