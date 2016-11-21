var Sniper = Sniper || {};
Sniper.NS = function(name) {
    var parts = name.split('.');
    var current = Sniper;
    for(var i in parts) {
        if(!current[parts[i]]) {
            current[parts[i]] = {};
        }
        current = current[parts[i]];
    }
}


Sniper.NS('KindEditor');
Sniper.KindEditor.init = function(formName,textAreaName) {
    KindEditor.ready(function(K) {
        var editor1 = K.create('textarea[name=' + textAreaName + ']', {
            cssPath : '/js/kindeditor/plugins/code/prettify.css', //防止出现相对路径的404错误
            //cssPath : '/js/kindeditor/plugins/code/prettify.css',
            uploadJson : 'bdd/upload',
            fileManagerJson : 'bdd/fileManager',
            allowFileManager : true,
            afterCreate : function() {
                var self = this;
                K.ctrl(document, 13, function() {
                    self.sync();
                    document.forms[formName].submit();
                });
                K.ctrl(self.edit.doc, 13, function() {
                    self.sync();
                    document.forms[formName].submit();
                });
            }
        });
        prettyPrint();
    });
}
