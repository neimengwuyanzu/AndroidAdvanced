package com.example.rxjavademo.bean;

import java.util.List;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
@lombok.NoArgsConstructor
@lombok.Data
public class WanArticle {

    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private DataDTO data;
    @com.fasterxml.jackson.annotation.JsonProperty("errorCode")
    private Integer errorCode;
    @com.fasterxml.jackson.annotation.JsonProperty("errorMsg")
    private String errorMsg;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class DataDTO {
        @com.fasterxml.jackson.annotation.JsonProperty("curPage")
        private Integer curPage;
        @com.fasterxml.jackson.annotation.JsonProperty("datas")
        private List<DatasDTO> datas;
        @com.fasterxml.jackson.annotation.JsonProperty("offset")
        private Integer offset;
        @com.fasterxml.jackson.annotation.JsonProperty("over")
        private Boolean over;
        @com.fasterxml.jackson.annotation.JsonProperty("pageCount")
        private Integer pageCount;
        @com.fasterxml.jackson.annotation.JsonProperty("size")
        private Integer size;
        @com.fasterxml.jackson.annotation.JsonProperty("total")
        private Integer total;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class DatasDTO {
            @com.fasterxml.jackson.annotation.JsonProperty("adminAdd")
            private Boolean adminAdd;
            @com.fasterxml.jackson.annotation.JsonProperty("apkLink")
            private String apkLink;
            @com.fasterxml.jackson.annotation.JsonProperty("audit")
            private Integer audit;
            @com.fasterxml.jackson.annotation.JsonProperty("author")
            private String author;
            @com.fasterxml.jackson.annotation.JsonProperty("canEdit")
            private Boolean canEdit;
            @com.fasterxml.jackson.annotation.JsonProperty("chapterId")
            private Integer chapterId;
            @com.fasterxml.jackson.annotation.JsonProperty("chapterName")
            private String chapterName;
            @com.fasterxml.jackson.annotation.JsonProperty("collect")
            private Boolean collect;
            @com.fasterxml.jackson.annotation.JsonProperty("courseId")
            private Integer courseId;
            @com.fasterxml.jackson.annotation.JsonProperty("desc")
            private String desc;
            @com.fasterxml.jackson.annotation.JsonProperty("descMd")
            private String descMd;
            @com.fasterxml.jackson.annotation.JsonProperty("envelopePic")
            private String envelopePic;
            @com.fasterxml.jackson.annotation.JsonProperty("fresh")
            private Boolean fresh;
            @com.fasterxml.jackson.annotation.JsonProperty("host")
            private String host;
            @com.fasterxml.jackson.annotation.JsonProperty("id")
            private Integer id;
            @com.fasterxml.jackson.annotation.JsonProperty("isAdminAdd")
            private Boolean isAdminAdd;
            @com.fasterxml.jackson.annotation.JsonProperty("link")
            private String link;
            @com.fasterxml.jackson.annotation.JsonProperty("niceDate")
            private String niceDate;
            @com.fasterxml.jackson.annotation.JsonProperty("niceShareDate")
            private String niceShareDate;
            @com.fasterxml.jackson.annotation.JsonProperty("origin")
            private String origin;
            @com.fasterxml.jackson.annotation.JsonProperty("prefix")
            private String prefix;
            @com.fasterxml.jackson.annotation.JsonProperty("projectLink")
            private String projectLink;
            @com.fasterxml.jackson.annotation.JsonProperty("publishTime")
            private Long publishTime;
            @com.fasterxml.jackson.annotation.JsonProperty("realSuperChapterId")
            private Integer realSuperChapterId;
            @com.fasterxml.jackson.annotation.JsonProperty("route")
            private Boolean route;
            @com.fasterxml.jackson.annotation.JsonProperty("selfVisible")
            private Integer selfVisible;
            @com.fasterxml.jackson.annotation.JsonProperty("shareDate")
            private Long shareDate;
            @com.fasterxml.jackson.annotation.JsonProperty("shareUser")
            private String shareUser;
            @com.fasterxml.jackson.annotation.JsonProperty("superChapterId")
            private Integer superChapterId;
            @com.fasterxml.jackson.annotation.JsonProperty("superChapterName")
            private String superChapterName;
            @com.fasterxml.jackson.annotation.JsonProperty("tags")
            private List<?> tags;
            @com.fasterxml.jackson.annotation.JsonProperty("title")
            private String title;
            @com.fasterxml.jackson.annotation.JsonProperty("type")
            private Integer type;
            @com.fasterxml.jackson.annotation.JsonProperty("userId")
            private Integer userId;
            @com.fasterxml.jackson.annotation.JsonProperty("visible")
            private Integer visible;
            @com.fasterxml.jackson.annotation.JsonProperty("zan")
            private Integer zan;
        }
    }
}
