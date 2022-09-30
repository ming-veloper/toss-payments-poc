module.exports = {
    mode: 'development',

    entry: '../templates/app.ts',

    module: {
        rules: [
            {
                test: /\.ts$/,
                use: 'ts-loader',
            },
        ],
    },

    resolve: {
        extensions: ['.ts', '.js'],
    },
};
