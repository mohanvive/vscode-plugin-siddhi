package io.siddhi.langserver.completion.providers;

import io.siddhi.langserver.LSContext;
import io.siddhi.langserver.completion.spi.LSCompletionProvider;
import io.siddhi.query.compiler.SiddhiQLParser;
import io.siddhi.langserver.completion.snippet.Snippet;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.checkerframework.checker.units.qual.A;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;

import java.util.ArrayList;
import java.util.List;



public class AttributeTypeContextProvider extends LSCompletionProvider {
    public AttributeTypeContextProvider(){

        this.attachmentPoints.add(SiddhiQLParser.Attribute_typeContext.class);
    }
    public List<CompletionItem> getCompletions(LSContext lsContext){
        List<CompletionItem> completionItems=new ArrayList<>();
        ParserRuleContext currcontext=lsContext.getCurrentContext();
        int st=currcontext.invokingState;
        IntervalSet expectedtokens=SiddhiQLParser._ATN.getExpectedTokens(st,currcontext);
        TerminalNode node=currcontext.getToken(expectedtokens.get(0),0);
        Snippet snippet=new Snippet();
        String[] atrtypes= snippet.getAttributetype(lsContext);

        for(String atr:atrtypes){
            CompletionItem completionItem = new CompletionItem();
            completionItem.setInsertText(atr);
            completionItem.setLabel(atr);
            completionItem.setKind(CompletionItemKind.Text);
            completionItem.setDetail("AttributeTypeContext");
            completionItems.add(completionItem);
        }
        return completionItems;
    }
}
