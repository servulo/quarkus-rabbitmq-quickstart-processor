package br.com.sprj.rabbitmq.processor;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import br.com.sprj.rabbitmq.model.Quote;
import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class QuoteProcessor {

	private Random random = new Random();

	@Incoming("requests")
	@Outgoing("quotes")
	@Blocking
	public Quote process(String quoteRequest) throws InterruptedException {
		Thread.sleep(1000);
		return new Quote(quoteRequest, random.nextInt(100));
	}

}
