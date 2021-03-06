package com.alorma.github.sdk.services.repo;

import android.content.Context;

import com.alorma.github.sdk.bean.dto.response.Branch;
import com.alorma.github.sdk.bean.info.RepoInfo;

import com.alorma.github.sdk.services.client.GithubClient;
import java.util.List;
import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by Bernat on 20/07/2014.
 */
public class GetRepoBranchesClient extends GithubRepoClient<List<Branch>> {

	public GetRepoBranchesClient(Context context, RepoInfo repoInfo) {
		super(context, repoInfo);
	}

	@Override
	protected Observable<List<Branch>> getApiObservable(RestAdapter restAdapter) {
		return restAdapter.create(RepoService.class).branches(getOwner(), getRepo());
	}
}
