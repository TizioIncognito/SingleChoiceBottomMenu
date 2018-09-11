package com.tizioIncognito.bottomsinglechoicemenu

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import java.util.Vector

class SingleChoiceBottomSheetMenu : BottomSheetDialogFragment() {
    private var title: String? = null
    private var subTitle: String? = null

    @StringRes private var titleRes: Int? = null
    @StringRes private var subTitleRes: Int? = null

    private val menuItems = Vector<MenuItem>()

    private inner class MenuItem(@param:DrawableRes @field:DrawableRes var icon: Int, var title: String, var subTitle: String?, var onClickListener: () -> Unit)

    fun addMenuItem(
            @DrawableRes icon: Int, title: String, subTitle: String?,
            onMenuItemClickListener:() -> Unit): SingleChoiceBottomSheetMenu {
        val menuItem = MenuItem(icon, title, subTitle, onMenuItemClickListener)
        menuItems.add(menuItem)
        return this
    }

    fun setMenuTitle(title: String): SingleChoiceBottomSheetMenu {
        this.title = title
        return this
    }

    fun setMenuTitle(@StringRes titleRes: Int): SingleChoiceBottomSheetMenu {
        this.titleRes = titleRes
        return this
    }

    fun setMenuSubTitle(subTitle: String): SingleChoiceBottomSheetMenu {
        this.subTitle = subTitle
        return this
    }

    fun setMenuSubTitle(@StringRes subTitleRes: Int): SingleChoiceBottomSheetMenu {
        this.subTitleRes = subTitleRes
        return this
    }



    fun show(appCompatActivity: AppCompatActivity) {
        super.show(appCompatActivity.supportFragmentManager, "TAG")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = View.inflate(context, R.layout.fragment_list_bottom_sheet, null)
        val itemList = contentView.findViewById<LinearLayout>(R.id.itemList)
        fillLayout(itemList)

        return contentView
    }

    private fun fillLayout(itemList: LinearLayout) {
        val titleMenu = itemList.findViewById<TextView>(R.id.titleMenu)
        if (title != null) {
            titleMenu.text = title
        } else {
            if (titleRes != null) {
                titleMenu.setText(titleRes!!)
            } else {
                titleMenu.visibility = View.GONE
            }
        }
        val subTitleMenu = itemList.findViewById<TextView>(R.id.subTitleMenu)
        if (subTitle != null) {
            subTitleMenu.text = subTitle
        } else {
            if (subTitleRes != null) {
                subTitleMenu.setText(subTitleRes!!)
            } else {
                subTitleMenu.visibility = View.GONE
            }
        }

        for (menuItem in menuItems) {
            val itemView = LayoutInflater.from(itemList.context).inflate(R.layout.list_item, itemList, false)

            val icon = itemView.findViewById<ImageView>(R.id.iconListItem)
            icon.setImageResource(menuItem.icon)

            val title = itemView.findViewById<TextView>(R.id.titleListItem)
            title.text = menuItem.title

            val subTitle = itemView.findViewById<TextView>(R.id.subTitleListItem)
            if (menuItem.subTitle != null) {
                subTitle.text = menuItem.subTitle
            } else {
                subTitle.visibility = View.GONE
            }

            itemView.setOnClickListener {
                dismiss()
                menuItem.onClickListener.invoke()
            }

            itemList.addView(itemView)
        }
    }

    companion object {

        fun create(): SingleChoiceBottomSheetMenu {
            return instance
        }

        private val instance: SingleChoiceBottomSheetMenu
            get() {
                val args = Bundle()
                val frag = SingleChoiceBottomSheetMenu()
                frag.arguments = args
                return frag
            }
    }

}