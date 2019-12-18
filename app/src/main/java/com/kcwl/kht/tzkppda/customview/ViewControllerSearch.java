/**
 * FileName: ViewControllerSearch
 * Author:baijie
 * Date: 2019/11/22 16:49
 * Description: 搜索框的页面
 */
package com.kcwl.kht.tzkppda.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.StringUtils;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: ViewControllerSearch
 * @Description: 搜索框的页面
 * @Author: baijie
 * @Date: 2019/11/22 16:49
 */
public class ViewControllerSearch extends LinearLayout
{

    @BindView(R.id.viewcontroller_search_cl_btn_search)
    Button btnSearch;
    @BindView(R.id.viewcontroller_search_cl_et_search)
    EditText etSearch;
    private SearchViewControllerOnClickListener searchViewControllerOnClickListener;


    public ViewControllerSearch(Context context)
    {
        super(context);
        initView();
    }

    public ViewControllerSearch(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initView();
    }

    public ViewControllerSearch(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView()
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.viewcontroller_search, this, false);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        addView(view);
        ButterKnife.bind(this, view);
    }


    @OnClick(R.id.viewcontroller_search_cl_btn_search)
    public void onViewClicked()
    {
        if (etSearch == null)
        {
            return;
        }

        String searchContent = etSearch.getText().toString().trim();
        if (StringUtils.isEmpty(searchContent))
        {
            ToastUtil.showLongToast(getContext(), getContext().getResources().getString(R.string.SearchviewHint));
            return;
        }

        if (searchViewControllerOnClickListener != null)
        {
            searchViewControllerOnClickListener.onClickSearchInputBox(searchContent);
        }
    }

    public interface SearchViewControllerOnClickListener
    {
        void onClickSearchInputBox(String searchContent);
    }


    public void setSearchViewControllerOnClickListener(SearchViewControllerOnClickListener searchViewControllerOnClickListener)
    {
        this.searchViewControllerOnClickListener = searchViewControllerOnClickListener;
    }
}