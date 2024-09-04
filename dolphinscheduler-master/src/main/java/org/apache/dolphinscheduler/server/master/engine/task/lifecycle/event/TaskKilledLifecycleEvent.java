/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.server.master.engine.task.lifecycle.event;

import org.apache.dolphinscheduler.server.master.engine.ILifecycleEventType;
import org.apache.dolphinscheduler.server.master.engine.task.lifecycle.AbstractTaskLifecycleEvent;
import org.apache.dolphinscheduler.server.master.engine.task.lifecycle.TaskLifecycleEventType;
import org.apache.dolphinscheduler.server.master.engine.task.runnable.ITaskExecutionRunnable;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TaskKilledLifecycleEvent extends AbstractTaskLifecycleEvent {

    private final ITaskExecutionRunnable taskExecutionRunnable;

    private final Date endTime;

    public static TaskKilledLifecycleEvent of(final ITaskExecutionRunnable taskExecutionRunnable) {
        return new TaskKilledLifecycleEvent(taskExecutionRunnable, new Date());
    }

    @Override
    public ILifecycleEventType getEventType() {
        return TaskLifecycleEventType.KILLED;
    }

    @Override
    public String toString() {
        return "TaskKilledLifecycleEvent{" +
                "task" + taskExecutionRunnable.getName() +
                ", endTime=" + endTime +
                '}';
    }
}
