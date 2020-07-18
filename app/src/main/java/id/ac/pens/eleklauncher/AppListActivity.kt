package id.ac.pens.eleklauncher

import android.app.WallpaperManager
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.activity_app_list.*
import java.util.*
import kotlin.collections.ArrayList

class AppListActivity : AppCompatActivity() {
    private val appList = ArrayList<AppItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)

        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        val i = Intent(Intent.ACTION_MAIN, null)
        i.addCategory(Intent.CATEGORY_LAUNCHER)

        val allApps:List<ResolveInfo> = packageManager.queryIntentActivities(i, 0)
        Collections.sort(allApps, ResolveInfo.DisplayNameComparator(packageManager))
        for(ri:ResolveInfo in allApps) run {
            val appItem = AppItem()
            appItem.label = ri.loadLabel(packageManager).toString()
            appItem.name = ri.activityInfo.packageName
            appItem.icon = ri.activityInfo.loadIcon(packageManager)
            appList.add(appItem)
        }

        val appListAdapter = AppListAdapter(appList)
        val statusBarHeightDp = resources.getIdentifier("status_bar_height", "dimen", "android")
        val statusBarHeightPx = resources.getDimensionPixelSize(statusBarHeightDp)
        val navigationBarHeightDp = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val navigationBarHeightPx = resources.getDimensionPixelSize(navigationBarHeightDp)

        rv_app_list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = appListAdapter
            setPadding(0, statusBarHeightPx, 0,navigationBarHeightPx)
        }
    }
}