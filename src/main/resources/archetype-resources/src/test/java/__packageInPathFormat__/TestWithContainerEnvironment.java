#set( $dt = $groupId.getClass().forName("java.util.Date").newInstance() )
#set( $year = $dt.getYear() + 1900 )
/* -*- mode: Java; c-basic-offset: 2; indent-tabs-mode: nil; coding: utf-8-unix -*-
 *
 * Copyright © ${year}#if ("${groupId}" == "org.microbean") microBean™.
#else

#end
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package ${package};

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;

import javax.enterprise.event.Observes;

import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

@ApplicationScoped
public class TestWithContainerEnvironment {


  /*
   * Instance fields.
   */


  private AutoCloseable container;


  /*
   * Constructors.
   */


  public TestWithContainerEnvironment() {
    super();
  }


  /*
   * Instance methods.
   */


  @Before
  public void startContainer() throws Exception {
    this.stopContainer();
    final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    this.container = initializer.initialize();
  }

  @After
  public void stopContainer() throws Exception {
    if (this.container != null) {
      this.container.close();
      this.container = null;
    }
  }

  private final void onStartup(@Observes @Initialized(ApplicationScoped.class) final Object event) {
    assertNotNull(event);
  }

  @Test
  public void testContainerStartup() {

  }

}
