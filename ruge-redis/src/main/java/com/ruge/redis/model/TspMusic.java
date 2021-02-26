package com.ruge.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TspMusic
 * @date 2020.09.15 11:41
 */
@Data
@Entity
@Builder
@Table(name = "tsp_music")
@NoArgsConstructor
@AllArgsConstructor
public class TspMusic {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    private String id;
    /**
     * tsp用户id
     */
    @Column(columnDefinition = "varchar(32) COMMENT 'tspId'")
    private String tspId;
    /**
     * 歌曲名称
     */
    @Column(columnDefinition = "varchar(32) COMMENT '歌曲名称'")
    private String musicName;
    /**
     * 歌曲播放次数
     */
    @Column(columnDefinition = "varchar(32) COMMENT '歌曲播放次数'")
    private String musicCount;
    /**
     * 排序
     */
    @Column(columnDefinition = "int COMMENT '排序'")
    private Integer sort;
    @Column(columnDefinition = "varchar(32) COMMENT '用户id'")
    private String aid;
}
