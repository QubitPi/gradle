/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.reporting.model

import org.gradle.integtests.fixtures.AbstractIntegrationSpec

class ModelReportTaskIntegrationTest extends AbstractIntegrationSpec {

    def "should display the model report task options"() {
        given:
        buildFile << """
            plugins {
                id 'model-reporting-tasks'
            }
        """

        when:
        run "help", "--task", "model"

        then:
        output.contains("Displays the configuration model of root project '${getTestDirectory().name}'. [deprecated]")
    }

}
