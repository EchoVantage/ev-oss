package org.echovantage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ServiceLoader;

import org.echovantage.compile.RuntimeClassLoader;
import org.echovantage.sample.SampleAnnotation;
import org.echovantage.sample.SampleService;
import org.junit.Test;

public class AnnotationTest {
	@Test
	public void testAnnotation() throws IOException {
		final RuntimeClassLoader loader = new RuntimeClassLoader(System.out);
		assertTrue(loader.compile(Paths.get("src/test/java")));
		final ServiceLoader<SampleService.Factory> factories = ServiceLoader.load(SampleService.Factory.class, loader);
		final SampleService.Factory factory = factories.iterator().next();
		assertEquals("example", factory.getClass().getAnnotation(SampleAnnotation.class).value());
		assertEquals("config:something", factory.create("config").doSomething("something"));
	}
}