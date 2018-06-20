package {{ cookiecutter.package_name }}.core

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import {{ cookiecutter.package_name }}.R

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val viewModelClass: Class<VM>) : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutRes(): Int

    lateinit var viewModel: VM
    lateinit var mBinding: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInject()
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel = getViewM()
    }

    private fun getViewM(): VM {
        return ViewModelProviders.of(this).get(viewModelClass)
    }

    open fun onInject() {}

    override fun onPause() {
        super.onPause()
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy(this)
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop(this)
    }
}





