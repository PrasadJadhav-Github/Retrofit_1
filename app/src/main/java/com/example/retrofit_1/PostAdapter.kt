import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofit_1.R
import com.example.retrofit_1.UserModel

class PostAdapter(private val posts : List<UserModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView : View ) : ViewHolder(itemView) {
        var titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        var likesTextView = itemView.findViewById<TextView>(R.id.likesTextView)
        var dislikesTextView = itemView.findViewById<TextView>(R.id.dislikesTextView)
        var viewsTextView = itemView.findViewById<TextView>(R.id.viewsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.titleTextView.text = " Title: ${posts[position].title}"
        holder.likesTextView.text = " Likes : ${posts[position].reactions.likes.toString()}"
        holder.dislikesTextView.text = "dislikes: ${posts[position].reactions.dislikes.toString()}"
        holder.viewsTextView.text = "views: ${posts[position].views.toString()}"
    }
}