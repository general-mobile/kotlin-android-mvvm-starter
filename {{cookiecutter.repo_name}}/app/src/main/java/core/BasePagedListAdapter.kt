package {{ cookiecutter.package_name }}.core

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import {{ cookiecutter.package_name }}.R

abstract class BasePagedListAdapter(diffCallback: DiffUtil.ItemCallback<BaseEntity> = BaseDiffCallback()) : PagedListAdapter<BaseEntity, androidx.recyclerview.widget.RecyclerView.ViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = getViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<*>).binding.root.setTag(R.string.position, position)
        bind(holder.binding, position)
    }

    open fun getViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = BaseViewHolder(createBinding(parent, viewType))

    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding

    protected abstract fun bind(binding: ViewDataBinding, position: Int)

    fun setList(list: PagedList<*>?) {
        submitList(list as PagedList<BaseEntity>?)
    }

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        open class BaseDiffCallback : DiffUtil.ItemCallback<BaseEntity>() {
            override fun areItemsTheSame(oldItem: BaseEntity, newItem: BaseEntity) = oldItem == newItem
            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: BaseEntity, newItem: BaseEntity) = oldItem == newItem
        }
    }
}