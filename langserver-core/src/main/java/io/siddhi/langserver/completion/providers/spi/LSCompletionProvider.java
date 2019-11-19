package io.siddhi.langserver.completion.providers.spi;

import com.mchange.v1.util.ArrayUtils;
import io.siddhi.langserver.LSOperationContext;
import io.siddhi.langserver.completion.providers.snippet.SnippetProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@code LSCompletionProvider} CompletionProvider SPI.
 */
public abstract class LSCompletionProvider {

    protected String attachmentContext;
    protected CompletionItemKind completionItemKind;
    protected SnippetProvider snippetProvider = new SnippetProvider();

    public abstract List<CompletionItem> getCompletions();

    protected static ArrayList<String> scopes;

    public String getAttachmentContext() {

        return this.attachmentContext;
    }

    public List<CompletionItem> generateCompletionList(List<Object[]> suggestions) {
        //todo: make completionItems class local
        List<CompletionItem> completionItems = new ArrayList<>();
        //todo:check isNull
        if (suggestions != null) {
            //todo:suggestion array size is 4???
            for (Object[] suggestion : suggestions) {
                CompletionItem completionItem = new CompletionItem();
                completionItem.setInsertText((String) suggestion[0]);
                completionItem.setLabel((String) suggestion[1]);
                completionItem.setKind((CompletionItemKind) suggestion[2]);
                completionItem.setDetail((String) suggestion[3]);
                completionItem.setFilterText((String) suggestion[4]);
                completionItems.add(completionItem);
            }
        }
        return completionItems;
    }

    public ParserRuleContext findScope() {
        //todo: what if current context is null
        ParserRuleContext currentContext = LSOperationContext.INSTANCE.getCurrentContext();
        ParserRuleContext scopeContext = findAncestorContext(currentContext);
        return scopeContext;
    }

    public static ParserRuleContext findAncestorContext(ParserRuleContext currentContext) {

        if (scopes.contains(currentContext.getClass().getName())) {
            return currentContext;
            //todo: check if parent context null????
        } else if(currentContext.getParent()!= null) {
            return findAncestorContext(currentContext.getParent());
        }
        else {
            return null;
        }
    }

    public ParserRuleContext visitParent() {

        Map<String, ParseTree> map = LSOperationContext.INSTANCE.getContextTree();
        ParserRuleContext parent = (ParserRuleContext) map.get(this.attachmentContext).getParent();
        return parent;
    }

}
