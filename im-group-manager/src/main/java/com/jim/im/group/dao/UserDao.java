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
package com.jim.im.group.dao;

import java.util.List;

import com.jim.im.db.base.EntityDao;
import com.jim.im.db.entity.group.User;



/**
 * 
 * @version 1.0.0
 */
public interface UserDao extends EntityDao<User>{

    /**
     * @param appId
     * @param tenantId
     * @param userIds
     * @return
     */
    int findUsersCountInUserIds(String appId, String tenantId, Integer... userIds);

    /**
     * @param appId
     * @param tenantId
     * @param groupId
     * @return
     */
    List<User> listGroupUser(String appId, String tenantId, Integer groupId);

}
