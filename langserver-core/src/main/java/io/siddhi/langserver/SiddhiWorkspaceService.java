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
package io.siddhi.langserver;

import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.services.WorkspaceService;

/**
 * Implementation of LSP4J Workspace Service, provide Workspace services {@link WorkspaceService} supported by lsp4j
 * Siddhi Language server have not implemented the workspace services yet.
 */
public class SiddhiWorkspaceService implements WorkspaceService {

    SiddhiWorkspaceService() {

    }

    /**
     * If the workspace configurations are changed this method gets executed.
     *
     * @param params
     */
    @Override
    public void didChangeConfiguration(DidChangeConfigurationParams params) {

        return;
        //operation not supported;
        //todo:check what comes here.
    }

    /**
     * This method gets executed If the files that are specifically being watched change.
     *
     * @param didChangeWatchedFilesParams
     */
    @Override
    public void didChangeWatchedFiles(DidChangeWatchedFilesParams didChangeWatchedFilesParams) {

        return;
        //operation not supported.
    }
}
