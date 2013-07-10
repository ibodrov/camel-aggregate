package jet.scdp.router.camel.processor;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

public class RouteTest2 extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "test_route2.xml";
    }

    @Test
    public void testSimple() throws Exception {
        String body = "A,B,C";
        Map<String, Object> headers = new HashMap<>();
        headers.put("txId", System.currentTimeMillis());
        template.sendBodyAndHeaders("direct:start", body, headers);
    }
}
