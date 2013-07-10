package jet.scdp.router.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class TestStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        Message m1 = oldExchange.getIn();
        Message m2 = newExchange.getIn();

        String s1 = m1.getBody(String.class);
        String s2 = m2.getBody(String.class);

        String result = s1 + " // " + s2;
        oldExchange.getIn().setBody(result);

        return oldExchange;
    }
}
