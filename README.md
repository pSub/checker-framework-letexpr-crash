Checker Framework crash: LetExpr is not part of a public API
============================================================

**The bug has been fixed!**

This repository contains Java code that triggers the `LetExpr is not part of a public API` assertion error when running
any checker of the [checker framework](https://checkerframework.org/). The issue was first reported in issue
[#469](https://github.com/typetools/checker-framework/issues/469) but without a minimal working example. The code in this
repository provides a minimal working example using only plain java. The [tracis-ci job](https://travis-ci.org/pSub/checker-framework-letexpr-crash)
provides a demonstration. 

The resulting error, including stacktrace, is the following:


     SourceChecker.typeProcess: unexpected Throwable (AssertionError) while processing /home/pascal/projects/letexpr/src/main/java/simplecrash/SomeRandomClass.java; message: LetExpr is not part of a public API
       Compilation unit: /home/pascal/projects/letexpr/src/main/java/simplecrash/SomeRandomClass.java
       Exception: java.lang.AssertionError: LetExpr is not part of a public API; Stack trace: com.sun.tools.javac.tree.JCTree$LetExpr.getKind(JCTree.java:2429)
       com.sun.source.util.TreePath.<init>(TreePath.java:97)
       com.sun.source.util.TreePathScanner.scan(TreePathScanner.java:66)
       com.sun.source.util.TreePath$1PathFinder.scan(TreePath.java:70)
       com.sun.source.util.TreePath$1PathFinder.scan(TreePath.java:65)
       com.sun.source.util.TreeScanner.visitExpressionStatement(TreeScanner.java:243)
       com.sun.tools.javac.tree.JCTree$JCExpressionStatement.accept(JCTree.java:1302)
       com.sun.source.util.TreePathScanner.scan(TreePathScanner.java:50)
       com.sun.source.util.TreePath.getPath(TreePath.java:79)
       org.checkerframework.framework.type.AnnotatedTypeFactory.getPath(AnnotatedTypeFactory.java:2819)
       org.checkerframework.framework.util.defaults.QualifierDefaults.nearestEnclosingExceptLocal(QualifierDefaults.java:386)
       org.checkerframework.framework.util.defaults.QualifierDefaults.applyDefaults(QualifierDefaults.java:473)
       org.checkerframework.framework.util.defaults.QualifierDefaults.annotate(QualifierDefaults.java:372)
       org.checkerframework.framework.type.GenericAnnotatedTypeFactory.addComputedTypeAnnotations(GenericAnnotatedTypeFactory.java:1391)
       org.checkerframework.framework.type.GenericAnnotatedTypeFactory.addComputedTypeAnnotations(GenericAnnotatedTypeFactory.java:1375)
       org.checkerframework.framework.type.AnnotatedTypeFactory.getAnnotatedType(AnnotatedTypeFactory.java:995)
       org.checkerframework.framework.type.AnnotatedTypeFactory.getAnnotatedType(AnnotatedTypeFactory.java:2364)
       org.checkerframework.framework.type.GenericAnnotatedTypeFactory.performFlowAnalysis(GenericAnnotatedTypeFactory.java:954)
       org.checkerframework.framework.type.GenericAnnotatedTypeFactory.checkAndPerformFlowAnalysis(GenericAnnotatedTypeFactory.java:1422)
       org.checkerframework.framework.type.GenericAnnotatedTypeFactory.preProcessClassTree(GenericAnnotatedTypeFactory.java:247)
       org.checkerframework.common.basetype.BaseTypeVisitor.visitClass(BaseTypeVisitor.java:295)
       org.checkerframework.common.basetype.BaseTypeVisitor.visitClass(BaseTypeVisitor.java:166)
       com.sun.tools.javac.tree.JCTree$JCClassDecl.accept(JCTree.java:720)
       com.sun.source.util.TreePathScanner.scan(TreePathScanner.java:50)
       org.checkerframework.framework.source.SourceVisitor.visit(SourceVisitor.java:66)
       org.checkerframework.framework.source.SourceChecker.typeProcess(SourceChecker.java:967)
       org.checkerframework.common.basetype.BaseTypeChecker.typeProcess(BaseTypeChecker.java:502)
       org.checkerframework.javacutil.AbstractTypeProcessor$AttributionTaskListener.finished(AbstractTypeProcessor.java:185)
       com.sun.tools.javac.api.ClientCodeWrapper$WrappedTaskListener.finished(ClientCodeWrapper.java:681)
       com.sun.tools.javac.api.MultiTaskListener.finished(MultiTaskListener.java:111)
       com.sun.tools.javac.main.JavaCompiler.flow(JavaCompiler.java:1342)
       com.sun.tools.javac.main.JavaCompiler.flow(JavaCompiler.java:1296)
       com.sun.tools.javac.main.JavaCompiler.compile2(JavaCompiler.java:901)
       com.sun.tools.javac.main.JavaCompiler.compile(JavaCompiler.java:860)
       com.sun.tools.javac.main.Main.compile(Main.java:523)
       com.sun.tools.javac.api.JavacTaskImpl.doCall(JavacTaskImpl.java:129)
       com.sun.tools.javac.api.JavacTaskImpl.call(JavacTaskImpl.java:138)
       org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess(JavaxToolsCompiler.java:126)
       org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile(JavacCompiler.java:174)
       org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute(AbstractCompilerMojo.java:1075)
       org.apache.maven.plugin.compiler.CompilerMojo.execute(CompilerMojo.java:168)
       org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
       org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:208)
       org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:154)
       org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:146)
       org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:117)
       org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:81)
       org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
       org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
       org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:309)
       org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:194)
       org.apache.maven.DefaultMaven.execute(DefaultMaven.java:107)
       org.apache.maven.cli.MavenCli.execute(MavenCli.java:993)
       org.apache.maven.cli.MavenCli.doMain(MavenCli.java:345)
       org.apache.maven.cli.MavenCli.main(MavenCli.java:191)
       sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
       sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
       sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
       java.lang.reflect.Method.invoke(Method.java:498)
       org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
       org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
       org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
       org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
