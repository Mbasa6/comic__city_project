package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
/**
 * Mpumzi Mbula
 * 219053324
 * 17/05/2024
 *
 */
@Entity
public class Wishlist{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long wishListId;
        private String wishlistName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ComicBook> comicBooks;
        private LocalDate createdDate;
        private LocalDate updatedDate;


        protected Wishlist(Builder builder){
            this.wishListId=builder.wishListId;
            this.wishlistName= builder.wishlistName;;
            this.comicBooks=builder.comicBooks;
            this.createdDate=builder.createdDate;
            this.updatedDate=builder.updatedDate;

        }

    public Wishlist() {

    }

    public long getWishListId() {
        return wishListId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlist wishlist)) return false;
        return Objects.equals(wishListId, wishlist.wishListId) && Objects.equals(wishlistName, wishlist.wishlistName) && Objects.equals(comicBooks, wishlist.comicBooks) && Objects.equals(createdDate, wishlist.createdDate) && Objects.equals(updatedDate, wishlist.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishListId, wishlistName, comicBooks, createdDate, updatedDate);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishListId=" + wishListId +
                ", wishlistName='" + wishlistName + '\'' +
                ", comicBooks=" + comicBooks +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    public static class Builder{
        private long wishListId;
        private String wishlistName;
        private List<ComicBook> comicBooks;
        private LocalDate createdDate;
        private LocalDate updatedDate;
        public Builder(){

        }

        public Builder setWishListId(long wishListId) {
            this.wishListId = wishListId;
            return this;
        }

        public Builder setWishlistName(String wishlistName) {
            this.wishlistName = wishlistName;
            return this;
        }

        public Builder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public Builder setCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder setUpdatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public Builder copy(Wishlist wishlist){
            this.wishListId=wishlist.wishListId;
           this.wishlistName=wishlist.wishlistName;
           this.comicBooks=wishlist.comicBooks;
           this.createdDate=wishlist.createdDate;
           this.updatedDate=wishlist.updatedDate;
           return this;
        }

        public Wishlist build(){
            return new Wishlist(this);
        }
    }


}
