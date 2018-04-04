package priv.rdo.ph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping("test")
    List<DummyObject> dummyMethod() {
        LOG.info("entered");
        return List.of(new DummyObject("test"), new DummyObject("tes2"));
    }

    static class DummyObject {
        private final String dummyField;

        DummyObject(String dummyField) {
            this.dummyField = dummyField;
        }

        public String getDummyField() {
            return dummyField;
        }
    }
}
