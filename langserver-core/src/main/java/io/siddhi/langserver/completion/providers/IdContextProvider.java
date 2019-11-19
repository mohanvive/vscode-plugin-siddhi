package io.siddhi.langserver.completion.providers;

import io.siddhi.langserver.completion.providers.spi.LSCompletionProvider;
import io.siddhi.query.compiler.SiddhiQLParser;
import org.eclipse.lsp4j.CompletionItem;

import java.util.List;

public class IdContextProvider  extends LSCompletionProvider {
    public IdContextProvider() {
        this.attachmentContext = SiddhiQLParser.IdContext.class.getName();
    }

    @Override
    public List<CompletionItem> getCompletions() {
        return generateCompletionList(null);
    }

}