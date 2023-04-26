/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

/**
 * MainActivity sets the content view activity_main, a fragment container that contains
 * overviewFragment.
 */
private val TAG = MainActivity::class.qualifiedName
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("main before call")
        val intent = Intent(this,MyService::class.java)
        startService(intent)
        /*println("main 1")
        GlobalScope.launch {
            println("main 2")
            delay(3000)
            println("main 3")
        }
        println("main 4")
        runBlocking {
            println("main 2.5")
            delay(1000)
            println("main 5")
        }*/
        /*runBlocking {
            val startTime = System.currentTimeMillis()
            val job = launch(Dispatchers.Default) {
                var nextPrintTime = startTime
                var i = 0
                while (isActive) { // computation loop, just wastes CPU
                    // print a message twice a second
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("main: I'm sleeping ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
            }
            delay(1300L) // delay a bit
            println("main: I'm tired of waiting!")
            job.cancelAndJoin() // cancels the job and waits for its completion
            println("main: Now I can quit.")
        }*/


        /*Log.d(TAG,"before runblock")

        runBlocking {
            val defer = async{
                repeat(1000){i->
                    Log.d(TAG,"I am sleeping $i")
                    delay(500)
                }
            }
            delay(3000)
            Log.d(TAG,"tired of waiting")
            defer.cancel()
            defer.join()
        }

        Log.d(TAG,"after runblock")*/
    }

    private suspend fun doWork() = coroutineScope{
        val job = launch{
            delay(2000)
            Log.d(TAG,"World")
        }
        Log.d(TAG,"Hello")
        job.join()
        Log.d(TAG,"Done")
    }

    suspend fun getValue():Double{
        delay(3000)
        return Math.random()
    }
}