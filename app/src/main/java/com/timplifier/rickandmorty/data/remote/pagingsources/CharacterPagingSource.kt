package com.timplifier.rickandmorty.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.timplifier.rickandmorty.common.constants.Constants.CHARACTER_KEY
import com.timplifier.rickandmorty.data.remote.apiservices.CharactersApiService
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSource(private val charactersApiService: CharactersApiService) :
    PagingSource<Int, RickAndMortyCharacter>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyCharacter> {
        val page = params.key ?: CHARACTER_KEY
        return try {
            val response = charactersApiService.fetchCharacters()
            val nextPageNumber = Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = response.results
                        prevkey = null
                        nextKey = nextPageNumber
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RickAndMortyCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}