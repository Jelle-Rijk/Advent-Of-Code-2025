package com.jellerijk.aoc.aoc2025.util.interfaces;

public record PublisherMessage(Publisher source, PublisherMessageType type, String payload) {
	public static PublisherMessage empty() {
		return new PublisherMessage(null, PublisherMessageType.EMPTY, null);
	}

	public boolean isEmpty() {
		return type == PublisherMessageType.EMPTY;
	}
}
