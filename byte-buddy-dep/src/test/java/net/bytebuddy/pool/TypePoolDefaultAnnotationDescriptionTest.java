package net.bytebuddy.pool;

import net.bytebuddy.description.annotation.AbstractAnnotationDescriptionTest;
import net.bytebuddy.description.annotation.AnnotationDescription;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class TypePoolDefaultAnnotationDescriptionTest extends AbstractAnnotationDescriptionTest {

    protected AnnotationDescription describe(Annotation annotation, Class<?> declaringType) {
        TypePool typePool = TypePool.Default.of(declaringType.getClassLoader());
        try {
            return typePool.describe(declaringType.getName()).resolve()
                    .getDeclaredAnnotations().ofType(annotation.annotationType());
        } finally {
            typePool.clear();
        }
    }

    @Test
    @Override
    @Ignore("Needs API to extract missing value, e.g. annotationValue.filter(...)")
    public void testBrokenAnnotationToString() throws Exception {
        super.testBrokenAnnotationToString();
    }
}
