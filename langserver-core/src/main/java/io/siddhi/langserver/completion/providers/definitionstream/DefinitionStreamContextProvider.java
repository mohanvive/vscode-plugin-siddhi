/*
 * Copyright (c) 2019, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.siddhi.langserver.completion.providers.definitionstream;

import io.siddhi.langserver.LSCompletionContext;
import io.siddhi.langserver.completion.providers.CompletionProvider;
import io.siddhi.langserver.utils.SnippetBlockUtil;
import io.siddhi.query.compiler.SiddhiQLParser.Definition_streamContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.lsp4j.CompletionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides completions for DefinitionStreamContext.
 * {@link io.siddhi.query.compiler.SiddhiQLParser.Definition_streamContext}.
 */
public class DefinitionStreamContextProvider extends CompletionProvider {

    public DefinitionStreamContextProvider() {

        this.providerName = Definition_streamContext.class.getName();
    }

    @Override
    public List<CompletionItem> getCompletions() {

        List<Object[]> suggestions = new ArrayList<>();
        ParserRuleContext definitionStreamContext = (ParserRuleContext) LSCompletionContext.INSTANCE.getParseTreeMap()
                .get(Definition_streamContext.class.getName());
        int childCount = definitionStreamContext.getChildCount();
        if (childCount > 0) {
            suggestions.add(SnippetBlockUtil.ATTRIBUTE_LIST_SNIPPET);
        }
        return generateCompletionList(suggestions);
    }
}
