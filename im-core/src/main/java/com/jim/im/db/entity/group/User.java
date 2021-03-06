/*
 * Copyright 2014 Jim. All Rights Reserved.
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
package com.jim.im.db.entity.group;
 
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.jim.im.db.base.GenericEntity;
 
 /**
 * @version 1.0.0
 */
public class User extends GenericEntity {

    private static final long serialVersionUID = 1L;
    
    /**  网关用户ID  */
    private Integer gatewayUserId;

    /** id */
    private Integer id;
    
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Integer getGatewayUserId() {
        return gatewayUserId;
    }

    public void setGatewayUserId(Integer gatewayUserId) {
        this.gatewayUserId = gatewayUserId;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
