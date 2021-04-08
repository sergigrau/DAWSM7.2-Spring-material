package edu.fje.daw2.m07;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

public class DAW2Dialecte extends AbstractProcessorDialect {

    public DAW2Dialecte() {
        super(
                "DAW2 Dialecte",    // nom del dialecte
                "daw2",            // Dialecte prefix (daw2:*)
                1000); // Dialecte precedencia
    }


    /*
     * Initialize the dialect's processors.
     *
     * Note the dialect prefix is passed here because, although we set
     * "hello" to be the dialect's prefix at the constructor, that only
     * works as a default, and at engine configuration time the user
     * might have chosen a different prefix to be used.
     */
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new SalutarAttributeTagProcessor(dialectPrefix));
        return processors;
    }


}