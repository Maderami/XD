public class EntityDocument {

    public String id;
    public String title;
    public String author;
    public String creationDate;
    public String registrationDate;
    public String status;
    public int c;

    public EntityDocument(String id_, String title_, String author_, String creationDate_, String registrationDate_, String status_) {
        this.id = id_;
        this.title = title_;
        this.author = author_;
        this.creationDate = creationDate_;
        this.registrationDate = registrationDate_;
        this.status = status_;
    }

    public EntityDocument(String id, String title) {

        this(id, title, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate (String creationDate) {
        this.creationDate = creationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Documents{" +
                "Title:'" + title + '\'' +
                ", Id:" + id +
                ", Author:" + author +
                ", Datecreate:" + creationDate +
                ", Dateregistration:" + registrationDate +
                ", Status:" + status +
                '}';
    }

}
