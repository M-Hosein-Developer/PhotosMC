package ir.androidCoder.photosmc.domain.model

class PhotoResponse : ArrayList<PhotoResponse.PhotoResponseItem>(){
    data class PhotoResponseItem(
        val alt_description: String,
        val alternative_slugs: AlternativeSlugs,
        val asset_type: String,
        val blur_hash: String,
        val breadcrumbs: List<Any>,
        val color: String,
        val created_at: String,
        val current_user_collections: List<Any>,
        val description: String,
        val height: Int,
        val id: String,
        val liked_by_user: Boolean,
        val likes: Int,
        val links: Links,
        val promoted_at: String,
        val slug: String,
        val sponsorship: Sponsorship,
        val topic_submissions: TopicSubmissions,
        val updated_at: String,
        val urls: Urls,
        val user: User,
        val width: Int
    ) {
        data class AlternativeSlugs(
            val de: String,
            val en: String,
            val es: String,
            val fr: String,
            val `it`: String,
            val ja: String,
            val ko: String,
            val pt: String
        )
    
        data class Links(
            val download: String,
            val download_location: String,
            val html: String,
            val self: String
        )
    
        data class Sponsorship(
            val impression_urls: List<Any>,
            val sponsor: Sponsor,
            val tagline: String,
            val tagline_url: String
        ) {
            data class Sponsor(
                val accepted_tos: Boolean,
                val bio: String,
                val first_name: String,
                val for_hire: Boolean,
                val id: String,
                val instagram_username: String,
                val last_name: Any,
                val links: Links,
                val location: Any,
                val name: String,
                val portfolio_url: String,
                val profile_image: ProfileImage,
                val social: Social,
                val total_collections: Int,
                val total_illustrations: Int,
                val total_likes: Int,
                val total_photos: Int,
                val total_promoted_illustrations: Int,
                val total_promoted_photos: Int,
                val twitter_username: Any,
                val updated_at: String,
                val username: String
            ) {
                data class Links(
                    val followers: String,
                    val following: String,
                    val html: String,
                    val likes: String,
                    val photos: String,
                    val portfolio: String,
                    val self: String
                )
    
                data class ProfileImage(
                    val large: String,
                    val medium: String,
                    val small: String
                )
    
                data class Social(
                    val instagram_username: String,
                    val paypal_email: Any,
                    val portfolio_url: String,
                    val twitter_username: Any
                )
            }
        }
    
        data class TopicSubmissions(
            val film: Film,
            val food_drink: FoodDrink,
            val nature: Nature,
            val textures_patterns: TexturesPatterns
        ) {
            data class Film(
                val approved_on: String,
                val status: String
            )
    
            data class FoodDrink(
                val status: String
            )
    
            data class Nature(
                val status: String
            )
    
            data class TexturesPatterns(
                val status: String
            )
        }
    
        data class Urls(
            val full: String,
            val raw: String,
            val regular: String,
            val small: String,
            val small_s3: String,
            val thumb: String
        )
    
        data class User(
            val accepted_tos: Boolean,
            val bio: String,
            val first_name: String,
            val for_hire: Boolean,
            val id: String,
            val instagram_username: String,
            val last_name: String,
            val links: Links,
            val location: String,
            val name: String,
            val portfolio_url: String,
            val profile_image: ProfileImage,
            val social: Social,
            val total_collections: Int,
            val total_illustrations: Int,
            val total_likes: Int,
            val total_photos: Int,
            val total_promoted_illustrations: Int,
            val total_promoted_photos: Int,
            val twitter_username: String,
            val updated_at: String,
            val username: String
        ) {
            data class Links(
                val followers: String,
                val following: String,
                val html: String,
                val likes: String,
                val photos: String,
                val portfolio: String,
                val self: String
            )
    
            data class ProfileImage(
                val large: String,
                val medium: String,
                val small: String
            )
    
            data class Social(
                val instagram_username: String,
                val paypal_email: Any,
                val portfolio_url: String,
                val twitter_username: String
            )
        }
    }
}