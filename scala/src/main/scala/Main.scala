package com.francois

import java.security.MessageDigest
import java.util
import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}
import org.apache.commons.codec.binary.Base64


class Encrypt {
	val SALT: String = "2019-05-20"
	val IvSpec = new IvParameterSpec(new Array[Byte](16))


  def encrypt(key: String, value: String): String = {
    // val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val cipher: Cipher = Cipher.getInstance("AES/CTR/NoPadding")
    cipher.init(Cipher.ENCRYPT_MODE, keyToSpec(key), IvSpec)
    // cipher.init(Cipher.ENCRYPT_MODE, keyToSpec(key))
    Base64.encodeBase64String(cipher.doFinal(value.getBytes("UTF-8")))
  }

	def keyToSpec(key: String): SecretKeySpec = {
		/*
  16 bytes = AES-128
  24 bytes = AES-192
  32 bytes = AES-256
		*/
		var keyBytes: Array[Byte] = ("2019-05-21" + key).getBytes("UTF-8")
		// console.log("oo: "+ keyBytes)
		val sha: MessageDigest = MessageDigest.getInstance("SHA-256")
		keyBytes = sha.digest(keyBytes)
		// println(keyBytes.length)
		// keyBytes = util.Arrays.copyOf(keyBytes, 32)
		new SecretKeySpec(keyBytes, "AES")
	}

	def main(): String = {
		"test"
	}
}

object pingpong
{
    def main(args: Array[String])
    {
    	val errorMessage = """Error while reporting DataSource a:db2:mainframe:tst1:tpd500_transfert 
io.swagger.client.core.ApiError: (400) Unexpected response code. Content : HttpEntity(application/json,{"errors":[{"errorMessage":"Error parsing query:\nselect * from `Vertex` where uuid='datasource-category-Transfert d'Agence'\n                                                                        ^\nEncountered \" <IDENTIFIER> \"Agence \"\" at line 1, column 68.\nWas expecting one of:\n    <EOF> \n    <AND> ...\n    <OR> ...\n    <ORDER> ...\n    <GROUP> ...\n    <LIMIT> ...\n    <SKIP2> ...\n    <OFFSET> ...\n    <TIMEOUT> ...\n    <FETCHPLAN> ...\n    <LOCK> ...\n    <NOCACHE> ...\n    <PARA...) 
        at io.swagger.client.core.ApiInvoker.unmarshallApiResponse(ApiInvoker.scala:394) 
        at io.swagger.client.core.ApiInvoker$$anonfun$execute$2$$anonfun$apply$5$$anonfun$16.apply(ApiInvoker.scala:348) 
        at io.swagger.client.core.ApiInvoker$$anonfun$execute$2$$anonfun$apply$5$$anonfun$16.apply(ApiInvoker.scala:348) 
        at spray.httpx.TransformerPipelineSupport$WithTransformation.$tilde$greater(TransformerPipelineSupport.scala:33) 
        at io.swagger.client.core.ApiInvoker$$anonfun$execute$2$$anonfun$apply$5.apply(ApiInvoker.scala:348) 
        at io.swagger.client.core.ApiInvoker$$anonfun$execute$2$$anonfun$apply$5.apply(ApiInvoker.scala:346) 
        at scala.util.Success$$anonfun$map$1.apply(Try.scala:237) 
        at scala.util.Try$.apply(Try.scala:192) 
        at scala.util.Success.map(Try.scala:237) 
        at scala.concurrent.Future$$anonfun$map$1.apply(Future.scala:237) 
        at scala.concurrent.Future$$anonfun$map$1.apply(Future.scala:237) 
        at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:36) 
        at akka.dispatch.BatchingExecutor$AbstractBatch.processBatch(BatchingExecutor.scala:55) 
        at akka.dispatch.BatchingExecutor$BlockableBatch$$anonfun$run$1.apply$mcV$sp(BatchingExecutor.scala:91) 
        at akka.dispatch.BatchingExecutor$BlockableBatch$$anonfun$run$1.apply(BatchingExecutor.scala:91) 
        at akka.dispatch.BatchingExecutor$BlockableBatch$$anonfun$run$1.apply(BatchingExecutor.scala:91) 
        at scala.concurrent.BlockContext$.withBlockContext(BlockContext.scala:72) 
        at akka.dispatch.BatchingExecutor$BlockableBatch.run(BatchingExecutor.scala:90) 
        at akka.dispatch.TaskInvocation.run(AbstractDispatcher.scala:40) 
        at akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(ForkJoinExecutorConfigurator.scala:43) 
        at akka.dispatch.forkjoin.ForkJoinTask.doExec(ForkJoinTask.java:260) 
        at akka.dispatch.forkjoin.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1339) 
        at akka.dispatch.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979) 
        at akka.dispatch.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107) """

    	val o = new Encrypt
    	val k = o.encrypt("4a615812-9c6d-468a-b8ac-09f0193560c9",errorMessage) // SecretKeySpec
    	println(k)
    	// val t = o.keyToSpec("4a615812-9c6d-468a-b8ac-09f0193560c9")
    	// t.getBytes("UTF-8")
    }

}
