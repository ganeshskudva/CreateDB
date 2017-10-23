package com.example.gkudva.createdb;

/**
 * Created by gkudva on 19/10/17.
 */

public class Event {

    private String id;
    private String title;
    private String permalink;
    private String startDate;
    private String endDate;
    private String modifiedDate;

    private String cost;
    private String costType;

    private String thumb;
    private String category;
    private int bookmark;
    private String content;

    private String author;
    private String bartstation;
    private String excerpt;
    private String publishDate;
    private String tags;
    private String venueId;

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {

        return tags;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueId() {

        return venueId;
    }

    public Event(String id, String title, String permalink, String startDate, String endDate, String modifiedDate, String cost, String costType, String thumb, String category, int bookmark, String content, String author, String bartstation, String excerpt, String publishDate, String tags, String venueId) {

        this.id = id;
        this.title = title;
        this.permalink = permalink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.modifiedDate = modifiedDate;
        this.cost = cost;
        this.costType = costType;
        this.thumb = thumb;
        this.category = category;
        this.bookmark = bookmark;
        this.content = content;
        this.author = author;
        this.bartstation = bartstation;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
        this.tags = tags;
        this.venueId = venueId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }


    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {

        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }


    public String getCost() {
        return cost;
    }

    public String getCostType() {
        return costType;
    }


    public String getThumb() {
        return thumb;
    }

    public String getCategory() {
        return category;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {

        return content;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBartstation(String bartstation) {
        this.bartstation = bartstation;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public String getAuthor() {
        return author;
    }

    public String getBartstation() {
        return bartstation;
    }

    public String getExcerpt() {
        return excerpt;
    }


}
