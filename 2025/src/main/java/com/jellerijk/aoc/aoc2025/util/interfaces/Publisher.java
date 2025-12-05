package com.jellerijk.aoc.aoc2025.util.interfaces;

import java.util.List;

public interface Publisher {
	public default void notifySubscribers() {
		notifySubscribers(PublisherMessage.empty());
	}

	public default void notifySubscribers(PublisherMessage message) {
		getSubscribers().forEach(sub -> sub.update(message));
	}

	public default void subscribe(Subscriber sub) {
		getSubscribers().add(sub);
	}

	public default void unsubscribe(Subscriber sub) {
		getSubscribers().remove(sub);
	}

	public List<Subscriber> getSubscribers();
}
