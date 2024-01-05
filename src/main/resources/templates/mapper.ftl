<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackageUrl}.mapper.${entityName}Mapper">
    <sql id="resultColumns">
${resultColumns}

    </sql>
    <sql id="dynamicCondition">
        <where>
            1=1
            ${dynamicCondition}
        </where>
    </sql>

    <select id="getObjectById"   parameterType="${basePackageUrl}.entity.${entityName}"
            resultType="${basePackageUrl}.entity.${entityName}">
        select
        <include refid="resultColumns"/>
        from ${tableName} ${entityName} where id=<#noparse>#{id}</#noparse>
    </select>

    <select id="queryList" parameterType="${basePackageUrl}.entity.${entityName}"
            resultType="${basePackageUrl}.entity.${entityName}">
        select
        <include refid="resultColumns"/>
        from ${tableName} ${entityName}
        <include refid="dynamicCondition"/>
    </select>
    <select id="selectForPage"   resultType="${basePackageUrl}.entity.${entityName}">
        select
        <include refid="resultColumns"/>
        from ${tableName} ${entityName}
        <if test="${entityName} != null ">


            </if>

    </select>


    <insert id="insert" parameterType="${basePackageUrl}.entity.${entityName}">
        INSERT INTO ${tableName} (${insertname}) values(${insertvalue})
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="${basePackageUrl}.entity.${entityName}">
        update ${tableName}
        <set>

            ${cupdatevalue}
            version=version+1
            </set>
        where
        id =  <#noparse>#{id}</#noparse> and version= <#noparse>#{version}</#noparse>
    </update>


    <delete id="deleteByIds">
        delete
        from
        ${tableName}
        where
        id in
        <foreach collection="idList" item="id" index="index" open="(" close=")" separator=",">
            <#noparse>#{id}</#noparse>
        </foreach>
    </delete>

    <select id="count" parameterType="${basePackageUrl}.entity.${entityName}" resultType="java.lang.Integer">
        SELECT COUNT(*)
        FROM
        from ${tableName} ${entityName}
        <include refid="dynamicCondition"/>
    </select>
</mapper>

