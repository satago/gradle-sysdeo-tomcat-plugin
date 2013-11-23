/**
 * Copyright 2013 AnjLab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.anjlab.gradle

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project;

class SysdeoEclipseTomcatGeneratorExtension
{
    String rootDir = "src/main/webapp"
    boolean exportSource = false
    boolean reloadable = true
    boolean redirectLogger = true
    boolean updateXml = true
    String warLocation = ""
    String webPath = "/"
    Closure extraInfo
    List includeClasspath = []
    List excludeClasspath = []
    
    def init(Project project)
    {
        project.allprojects.each {
            excludeClasspath << "${it.name}"
            includeClasspath << "/${it.name}/bin"
        }
    }
}