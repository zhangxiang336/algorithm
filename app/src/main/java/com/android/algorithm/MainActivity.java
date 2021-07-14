package com.android.algorithm;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.android.algorithm.tree.traversal.breadth.BreadthTraversalViewTree;
import com.android.algorithm.tree.traversal.depth.DepthTraversalViewTree;
import com.android.algorithm.tree.traversal.recursion.RecursionPreTraversalViewTree;

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
            BreadthTraversalViewTree levelTraversalViewTree = new BreadthTraversalViewTree();
            levelTraversalViewTree.breadthTraversalViewTree(button1.getRootView());

        });
        Button button2 = findViewById(R.id.pre_tranversal_viewTree);
        button2.setOnClickListener(v -> {
            DepthTraversalViewTree levelTraversalViewTree = new DepthTraversalViewTree();
            levelTraversalViewTree.depthTraversalViewTree(button2.getRootView());
        });
        Button button3 = findViewById(R.id.recursion_tranversal_viewTree);
        button3.setOnClickListener(v -> {
            RecursionPreTraversalViewTree recursionTraversalViewTree = new RecursionPreTraversalViewTree();
            recursionTraversalViewTree.recursionPreTraversalViewTree(button3.getRootView());
        });

        Resources.getSystem();
    }
}

