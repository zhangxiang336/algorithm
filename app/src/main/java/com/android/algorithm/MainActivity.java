package com.android.algorithm;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.algorithm.tree.traversal.breadth.BreadthTraversalViewTree;
import com.android.algorithm.tree.traversal.depth.DepthTraversalViewTree;
import com.android.algorithm.tree.traversal.recursion.RecursionPreTraversalViewTree;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(v -> {
            finish();
        });

        Button button1 = findViewById(R.id.tranversal_viewTree);
        button1.setOnClickListener(v -> {
//            BreadthTraversalViewTree levelTraversalViewTree = new BreadthTraversalViewTree();
//            levelTraversalViewTree.breadthTraversalViewTree(button1.getRootView());
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.mipay.wallet");

            intent.setData(Uri.parse("https://app.mipay.com/?id=transfer"));
            PackageManager pm = getPackageManager();
            List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
            if (activities.size() <= 0) {
                Toast.makeText(MainActivity.this, "not support", Toast.LENGTH_SHORT).show();
            } else {
                startActivityForResult(intent, 1);
            }

        });
        Button button2 = findViewById(R.id.pre_tranversal_viewTree);
        button2.setOnClickListener(v -> {
//            DepthTraversalViewTree levelTraversalViewTree = new DepthTraversalViewTree();
//            levelTraversalViewTree.depthTraversalViewTree(button2.getRootView());

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.mipay.wallet");

            intent.addCategory("com.mipay.wallet.MIPAYINFO");
            intent.setData(Uri.parse("https://app.mipay.com/?id=mipay.info"));
            PackageManager pm = getPackageManager();
            List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
            if (activities.size() <= 0) {
                Toast.makeText(MainActivity.this, "not support", Toast.LENGTH_SHORT).show();
            } else {
                startActivityForResult(intent, 1);
            }
        });
        Button button3 = findViewById(R.id.recursion_tranversal_viewTree);
        button3.setOnClickListener(v -> {
//            RecursionPreTraversalViewTree recursionTraversalViewTree = new RecursionPreTraversalViewTree();
//            recursionTraversalViewTree.recursionPreTraversalViewTree(button3.getRootView());

            Intent intent = new Intent("android.intent.action.MIPAYINFO");
            intent.setPackage("com.mipay.wallet");
            List<ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, 0);
            if (activities.size() <= 0) {
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory("com.mipay.wallet.MIPAYINFO");
                intent.setData(Uri.parse("https://app.mipay.com/?id=mipay.info"));
            }
            startActivityForResult(intent, 1);

        });

        Resources.getSystem();
    }
}

