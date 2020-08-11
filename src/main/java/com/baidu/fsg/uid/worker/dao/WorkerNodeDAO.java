/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserve.
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
package com.baidu.fsg.uid.worker.dao;

import com.baidu.fsg.uid.worker.entity.WorkerNodeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * DAO for M_WORKER_NODE
 *
 * @author yutianbao
 */
@Repository
public interface WorkerNodeDAO {

    /**
     * Get {@link WorkerNodeEntity} by node host
     *
     * @param host
     * @param port
     * @return
     */
    @Select("SELECT\n" +
            "\t\tID,\n" +
            "\t\tHOST_NAME,\n" +
            "\t\tPORT,\n" +
            "\t\tTYPE,\n" +
            "\t\tLAUNCH_DATE,\n" +
            "\t\tMODIFIED,\n" +
            "\t\tCREATED\n" +
            "\t\tFROM\n" +
            "\t\tWORKER_NODE\n" +
            "\t\tWHERE\n" +
            "\t\tHOST_NAME = #{host} AND PORT = #{port}")
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

    /**
     * Add {@link WorkerNodeEntity}
     *
     * @param workerNodeEntity
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO WORKER_NODE\n" +
            "\t\t(HOST_NAME,\n" +
            "\t\tPORT,\n" +
            "\t\tTYPE,\n" +
            "\t\tLAUNCH_DATE,\n" +
            "\t\tMODIFIED,\n" +
            "\t\tCREATED)\n" +
            "\t\tVALUES (\n" +
            "\t\t#{hostName},\n" +
            "\t\t#{port},\n" +
            "\t\t#{type},\n" +
            "\t\t#{launchDate},\n" +
            "\t\tNOW(),\n" +
            "\t\tNOW())")
    void addWorkerNode(WorkerNodeEntity workerNodeEntity);

}
