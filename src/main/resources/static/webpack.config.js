module.exports = {
    mode: 'production',
    entry: './script/app.ts',
    module: {
        rules: [
            {
                test: /\.ts$/,
                use: 'ts-loader',
            },
        ],
    },
    output: {
        path: __dirname,
        filename: "somang.js"
    },
    resolve: {
        extensions: ['.ts', '.js'],
    },
};
