package id.ac.pens.eleklauncher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.app_item.view.*

class AppListAdapter(private val appList: List<AppItem>) :
    RecyclerView.Adapter<AppListAdapter.AppItemHolder>() {
    class AppItemHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvAppName = view.tvAppName
        private val ivIcon = view.ivIcon
        fun bindApp(app: AppItem) {
            tvAppName.text = app.label
            ivIcon.setImageDrawable(app.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppItemHolder {
        return AppItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.app_item, parent,false))
    }

    override fun getItemCount(): Int  = appList.size

    override fun onBindViewHolder(holder: AppItemHolder, position: Int) {
        holder.bindApp(appList[position])
    }

}